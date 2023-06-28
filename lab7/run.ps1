$src = $args[0] + ".java"
& "C:\Program Files\BellSoft\LibericaJDK-8-Full\bin\javac.exe" $src
& "C:\Program Files\BellSoft\LibericaJDK-8-Full\bin\java.exe" $args[0]