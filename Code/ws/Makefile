#
# Makefile pour compilation/execution de projets Java
#

SOURCES = $$(find ../src -name "*.java" | grep -v "/test/")
SOURCEST = $$(find ../src -name "*.java" | grep "/test/")
CLASS_DIR = class
JAVADOC_DIR = javaDoc
DATA_DIR = data
NAME = 'GIRAUD-RENARD'

NAME_TP=$$(echo "$(CURDIR)" | rev | cut -d/ -f2 | rev)

compile: mkdirclass
	@javac -d ../$(CLASS_DIR) $(SOURCES)
	
compilet: mkdirclass
	@javac -d ../$(CLASS_DIR) $(SOURCEST)
	
mkdirclass:
	@mkdir -p ../$(CLASS_DIR)
	
mkdirjavadoc:
	@rm -rf ../$(JAVADOC_DIR)
	@mkdir -p ../$(JAVADOC_DIR)
	
javadoc: mkdirjavadoc compile
	@javadoc -private -author -d ../$(JAVADOC_DIR) $(SOURCES)

run: compile
	@java -classpath ../$(CLASS_DIR) $(ARGS)
	
zip: compile javadoc
	zip -r ../$(NAME)-$(NAME_TP) ../src/
	zip -r ../$(NAME)-$(NAME_TP) ../$(JAVADOC_DIR)
	if test -d ../$(DATA_DIR) ; then zip -r ../$(NAME)-$(NAME_TP) ../$(DATA_DIR)/ ; fi
