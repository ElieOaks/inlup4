JUNIT = ".:/usr/share/java/junit4.jar:source"
JUNI = ".:/usr/share/java/junit4.jar:bin"


all:
	javac -cp $(JUNIT) ./source/*.java -d ./bin

test: all
	java -cp $(JUNI) TestFile

clean:
	rm -f *~
	rm -f *#
	rm -f ./source/*.#
	rm -f ./source/*~
	rm -f ./bin/*.class