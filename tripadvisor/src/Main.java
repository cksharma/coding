import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Entry class.
 * JVM invokes main method inside this class.
 */
public class Main {

    /**
     * inputHotelFile instance
     */
    private File inputHotelFile;

    /**
     * inputBookingFile instance
     */
    private File inputBookingFile;

    /**
     * checkin Date instance
     */
    private Date checkinDate;

    /**
     * checkout Date instacne
     */
    private Date checkoutDate;

    /**
     * Map with hotelName as key and Hotel object as value.
     * The Business Logic for hotel availability check is based on this map.
     */
    private Map<String, Hotel> hotelDetailsMap = new HashMap<>();

    /**
     * initializes the member variables of Main class with value received from program arguments
     * @param args input args with length 8
     */
    private void processInputArguments(String[] args) {

        if (args == null || args.length != 8) {
            throw new InvalidInputException(LoggerConstants.INVALID_INPUT_MESSAGE);
        }

        try {
            for (int i = 0; i < args.length; i++) {
                String params = args[i];

                if (params.equals("--hotels")) {
                    inputHotelFile = new File(args[++i]);
                } else if (params.equals("--bookings")) {
                    inputBookingFile = new File(args[++i]);
                } else if (params.equals("--checkin")) {
                    checkinDate = DateUtils.convertStrToYYYYMMDDDate(args[++i]);
                } else if (params.equals("--checkout")) {
                    checkoutDate = DateUtils.convertStrToYYYYMMDDDate(args[++i]);
                } else {
                    throw new InvalidInputException(LoggerConstants.INVALID_INPUT_MESSAGE);
                }
            }
            if (inputHotelFile == null || inputBookingFile == null || checkinDate == null || checkoutDate == null) {
                throw new InvalidInputException(LoggerConstants.INVALID_DATE_MESSAGE);
            } else if (checkinDate.compareTo(checkoutDate) >= 0) {
                throw new InvalidInputException(LoggerConstants.CHECKIN_CHECKOUT_DATE_EXECEPTION);
            }
        } catch(InvalidInputException | NullPointerException | IndexOutOfBoundsException ex ) {
            System.out.println(ex.getMessage());
            throw new InvalidInputException(LoggerConstants.INVALID_INPUT_MESSAGE);
        } catch(DateParseException ex) {
            System.out.println(ex.getMessage());
            throw new DateParseException(LoggerConstants.INVALID_DATE_MESSAGE);
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    /**
     * Reads the inputHotelFile and populates the Hotel details in hotelDetailsMap
     * Parameterized try ensures that instance of class implementing AutoClosable are closed by Java
     */
    private void populateHotelRooms() {
        try (FileReader fileReader = new FileReader(inputHotelFile);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#")) continue; // title columns

                String[] arr = line.split(",");
                String hotelName = arr[0];
                int totalRooms = Integer.parseInt(arr[1].trim());
                if (totalRooms > 0)
                    hotelDetailsMap.put(hotelName, new Hotel(hotelName, totalRooms));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new MyException(LoggerConstants.PROBLEM_READING_FILE + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(LoggerConstants.PROBLEM_READING_FILE + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Reads the inputBookingFile and populates the occupancy details in Hotels present in hotelDetailsMap
     */
    private void populateOccupancyFromBookings() {
        try (FileReader fileReader = new FileReader(inputBookingFile);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#")) continue; // title columns

                String[] arr = line.split(",");
                String hotelName = arr[0].trim();
                Date startDate  = DateUtils.convertStrToYYYYMMDDDate(arr[1].trim());
                Date endDate = DateUtils.convertStrToYYYYMMDDDate(arr[2].trim());

                //ignore all the records for hotels +nt in booking file but not in hotel files.
                if (!hotelDetailsMap.containsKey(hotelName)) continue;

                if (hotelDetailsMap.get(hotelName).getOccupancyMap() == null) {
                    hotelDetailsMap.get(hotelName).setOccupancyMap(new HashMap<>());
                }

                Map<Date, Integer> occupancyMap = hotelDetailsMap.get(hotelName).getOccupancyMap();

                while (startDate.compareTo(endDate) < 0) {
                    occupancyMap.put(startDate, occupancyMap.get(startDate) == null ? 1 : occupancyMap.get(startDate) + 1);
                    startDate = DateUtils.getTomorrowDate(startDate);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileReaderException(LoggerConstants.PROBLEM_READING_FILE + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileReaderException(LoggerConstants.PROBLEM_READING_FILE + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * for the given search criteria construct list which contains matching hotel names
     * @return list of hotels name satisfying the search criteria
     */
    private List<String> getHotelsWithAvailableRooms() {
        List<String> hotelsList = new ArrayList<>();
        for (String hotelName : hotelDetailsMap.keySet()) {
            Map<Date, Integer> occupancyMap = hotelDetailsMap.get(hotelName).getOccupancyMap();
            if (occupancyMap == null) {
                hotelsList.add(hotelName);
                continue;
            }
            boolean considerHotel = true;
            Date startDate = (Date)checkinDate.clone();
            Date endDate = (Date)checkoutDate.clone();
            while (startDate.compareTo(endDate) < 0) {
                if (occupancyMap.get(startDate) != null && occupancyMap.get(startDate) >= hotelDetailsMap.get(hotelName).getTotalRooms()) {
                    considerHotel = false;
                    break;
                }
                startDate = DateUtils.getTomorrowDate(startDate);
            }
            if (considerHotel) {
                hotelsList.add(hotelName);
            }
        }
        return hotelsList;
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.processInputArguments(args);
        main.populateHotelRooms();
        main.populateOccupancyFromBookings();
        List<String> hotelsList = main.getHotelsWithAvailableRooms();

        if (hotelsList.size() == 0) {
            System.out.println(LoggerConstants.NO_HOTELS_AVAILABLE);
        } else {
            System.out.println(LoggerConstants.MATCHING_RECORDS);
            System.out.println(hotelsList.toString());
        }
    }
}

/**
 * Represent the Hotel details.
 */
class Hotel {
    /**
     * Name of the hotel.
     */
    private String hotelName;

    /**
     * Registration number of hotel. e.g. PAN number
     */
    private String registrationNumber;

    /**
     * Map which keeps tracks of which dates are occupied already
     */
    private Map<Date, Integer> occupancyMap;

    /**
     * Total number of rooms in the hotel.
     */
    private int totalRooms;

    /**
     * Allows hotel to be created with hotelName, regNum
     * @param hotelName
     * @param registrationNumber
     */
    public Hotel(String hotelName, String registrationNumber) {
        this.hotelName = hotelName;
        this.registrationNumber = registrationNumber;
    }

    /**
     * Allows hotel to be created with hotelName, occupancyMap
     * @param hotelName
     * @param occupancyMap
     */
    public Hotel(String hotelName, Map<Date, Integer> occupancyMap) {
        this.hotelName = hotelName;
        this.occupancyMap = occupancyMap;
    }

    /**
     * Hotel instance created with hotelName and totalRooms.
     * @param hotelName
     * @param totalRooms
     */
    public Hotel(String hotelName, int totalRooms) {
        this.hotelName = hotelName;
        this.totalRooms = totalRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Map<Date, Integer> getOccupancyMap() {
        return occupancyMap;
    }

    public void setOccupancyMap(Map<Date, Integer> occupancyMap) {
        this.occupancyMap = occupancyMap;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }
}

/**
 * Logger/Exception messages constants
 */
final class LoggerConstants {
    /**
     * Exception message when input doesn't have 8 arguments
     */
    public static final String INVALID_INPUT_MESSAGE = "Input must have 8 arguments";

    /**
     * Exception message when date doesn't adhere with YYYY-MM-dd format
     */
    public static final String INVALID_DATE_MESSAGE = "Date must be in YYYY-MM-dd format";

    /**
     * Message displayed when there are no hotels available for given search criteria
     */
    public static final String NO_HOTELS_AVAILABLE = "Sorry, no hotels are available for your search criteria. Please try with different checkin/checkout date";

    /**
     * Message displayed before printing the hotel name list
     */
    public static final String MATCHING_RECORDS = "Following hotels match your search criteria";

    /**
     * Exception message when there is problem in reading input file
     */
    public static final String PROBLEM_READING_FILE = "Problem in reading input file";

    /**
     * Exception message when checkin date is >= checkout date
     */
    public static final String CHECKIN_CHECKOUT_DATE_EXECEPTION = "Checkin date cannot be greater or equal to checkout date";

}

/**
 * Custom exception to Warp exception message
 */
class MyException extends RuntimeException {

    private static final long serialVersionUID = 1556478797452799677L;
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

/**
 * Exception when input is invalid
 */
class InvalidInputException extends MyException {

    public InvalidInputException(String message) {
        super(message);
    }
}

/**
 * Wrapper class for Exception created when parsing date
 */
class DateParseException extends MyException {

    public DateParseException(String message) {
        super(message);
    }
}

class FileReaderException extends MyException {
    public FileReaderException(String message) {
        super(message);
    }
}

/**
 * Utility class for date
 */
final class DateUtils {
    private DateUtils() {

    }

    /**
     * Takes date as String with format yyyy-MM-dd
     * @param dateStr
     * @return Date object for the input dateStr
     * @throws DateParseException when SDF cannot parse dateStr
     */
    public static Date convertStrToYYYYMMDDDate(String dateStr) throws DateParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new DateParseException(e.getMessage());
        }
    }

    /**
     * Gets date and returns tomorrows date for that date
     * @param today
     * @return return tomorrow's date for the input date
     */
    static Date getTomorrowDate(Date today) {
        return new Date(today.getTime() + (1000 * 60 * 60 * 24));
    }
}
