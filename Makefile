start: compile run

compile:
	-@javac -d classes *.java

run:
	-@java -cp classes Supermercado
