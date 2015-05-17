package com.java2s.java.abstractclass;

import java.util.Scanner;

public abstract class AbstractClient {
  protected boolean running = true;

  protected void run() {
    Scanner scanner = new Scanner( "foo\\r\\nbar\\r\\n" );
    displayOptions();
    while ( running ) {
      String input = null;
      while ( scanner.hasNext() ) {
        input = scanner.next();
      }
      processInputCommand( input );
      running = false;
    }
  }

  abstract void displayOptions();

  abstract void processInputCommand( String input );

}