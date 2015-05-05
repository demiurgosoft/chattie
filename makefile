#Chattie Makefile
#by demiurgosoft

#Flags
COMPILER=javac
LINKER=jar

#Directories
SDIR=src
CDIR=classes
BDIR=bin
CLIENTDIR=$(BDIR)/client
SERVERDIR=$(BDIR)/server
_DIRECTORIES=$(BDIR) $(CDIR) $(CLIENTDIR) $(SERVERDIR)
DIRECTORIES=$(patsubst %,%/,$(_DIRECTORIES))


_CLIENT=ServerInterface.java ChatClient.java ClientInterface.java
CLIENT_CLASS=$(patsubst %,$(CDIR)/%,$(_CLIENT:.java=.class))
CLIENT_CLASS2=$(patsubst %,-C $(CDIR) %,$(_CLIENT:.java=.class))
_SERVER=ServerInterface.java ChatServer.java ClientInterface.java
SERVER_CLASS=$(patsubst %,$(CDIR)/%,$(_SERVER:.java=.class))
SERVER_CLASS2=$(patsubst %,-C $(CDIR) %,$(_SERVER:.java=.class))
CLIENT_BIN=$(CLIENTDIR)/ChattyClient.jar
SERVER_BIN=$(SERVERDIR)/ChattyServer.jar

.PHONY: all
all: $(DIRECTORIES) $(CLIENT_BIN) $(SERVER_BIN)


$(CLIENT_BIN): $(CLIENT_CLASS)
	$(LINKER) cfe $@ ChatClient $(CLIENT_CLASS2)
	
$(SERVER_BIN): $(SERVER_CLASS)
	$(LINKER) cfe $@ ChatServer $(SERVER_CLASS2)

#compile class
$(CDIR)/%.class: $(SDIR)/%.java
	$(COMPILER) -d $(CDIR) $^ -sourcepath $(SDIR)

%/:
	mkdir $@



.PHONY: astyle
astyle:
	astyle --style=java --break-closing-brackets --align-pointer=name --delete-empty-lines --indent-col1-comments --unpad-paren -n -Q $(SDIR)/*.java
.PHONY: clear
clean:
	rm -r -f  $(CDIR) $(BDIR) *~ $(SDIR)/*~ *.class *.jar

