CXXFLAGS =	-O2 -g -Wall -fmessage-length=0

OBJS =		Hello_World.o

LIBS =

TARGET =	Hello_World.exe

$(TARGET):	$(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
