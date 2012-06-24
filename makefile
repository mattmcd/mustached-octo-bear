all: ReportSpec.g SpecWalker.g 
	mkdir -p generated
	mkdir -p classes
	java org.antlr.Tool -o generated ReportSpec.g
	java org.antlr.Tool -o generated SpecWalker.g
	javac -cp $$CLASSPATH:generated -d classes Main.java generated/*.java

run:
	java -cp $$CLASSPATH:classes Main test.txt
