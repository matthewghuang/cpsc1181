javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls "$1.java" &&
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls "$1"