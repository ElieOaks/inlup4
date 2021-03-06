JUNIT = ".:/usr/share/java/junit4.jar:source"
JUNI = ".:/usr/share/java/junit4.jar:bin"


all:
	javac -cp $(JUNIT) ./source/*.java -d ./bin

runall: all
	java -cp $(JUNI) ParserDriver

test: all
	java -cp $(JUNI) TestFile

clean:
	rm -f *~
	rm -f *#
	rm -f ./source1/*#
	rm -f ./source1/*~

	rm -f ./bin/*.class
