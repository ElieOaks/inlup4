JUNIT = ".:/usr/share/java/junit4.jar:source"
JUNI = ".:/usr/share/java/junit4.jar:bin"


all:
	javac -cp $(JUNIT) ./source/*.java -d ./bin

runall: all
	java -cp $(JUNI) ParserDriver

test: all
	java -cp $(JUNI) TestFile

runall: all
	java -cp $(JUNI) ParserDriver

clean:
	rm -f *~
	rm -f *#
	rm -f ./source/*.#
	rm -f ./source/*~
	rm -f ./bin/*.class
