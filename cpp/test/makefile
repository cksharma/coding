CC=gcc
USER_CFLAGS=-I./src/sqr
SRCDIRS=./src/sqr
CFLAGS=-c -Wall


all: build_all

build_all: hellomake.o hellofunc.o
	$(CC) hellomake.o hellofunc.o -o hellomake			

hellomake.o: $(SRCDIRS)/hellomake.c
	$(CC) $(CFLAGS) -I./src/sqr $(SRCDIRS)/hellomake.c

hellofunc.o: $(SRCDIRS)/hellofunc.c
	$(CC) $(CFLAGS) -I./src/sqr $(SRCDIRS)/hellofunc.c
clean:
	rm -rf *o hellomake