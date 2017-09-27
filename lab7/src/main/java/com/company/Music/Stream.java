package main.java.com.company.Music;
import java.io.*;

public class Stream {
    public void SerializeObject(Object item, String filename) { //сериализация объекта в файл
        File file = new File(filename);
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
            out.writeObject(item);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public Object DeserializeObject(String filename) { //десериализация объекта с файла
        ObjectInputStream in = null;
        Object item = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(filename)));
            item = in.readObject();
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
            ex.printStackTrace();
            System.exit(1);
        }
        return item;
    }


    public void SerializeCollection(Album album, String filename) { //сериализация последовательности объектов
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filename)));
            int size = album.size();
            out.writeInt(size);
            for (int i = album.size()-1; i >=0; i--) {
                Object anAlbum = album.get(i);
                out.writeObject(anAlbum);
            }
            out.close();
        } catch (EOFException ex) {
            System.out.println("End of file!");
            System.exit(1);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public Album DeserializeCollection(String filename) { //десериализация последовательности объектов
        ObjectInputStream in = null;
        Album album = new Album();
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(filename)));
            int size = (int) in.readInt();
            for (int i = 0; i < size; i++) {
                album.add(in.readObject());
            }
            in.close();

        } catch (EOFException ex) {
            System.out.println("End of file!");
            System.exit(1);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
            ex.printStackTrace();
            System.exit(1);
        }
        return album;
    }

    public void WriteCollection(Album album, String filename) { //запись коллекции в виде текста в файл
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (int i = album.size()-1; i >= 0; i--) {
                writer.write(album.get(i).toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public Album ReadCollection(String filename) { //считывание коллекции из файла
        Album album = new Album();
        try (FileReader reader = new FileReader(filename)) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                StringBuilder buffer = new StringBuilder();
                while ((char) currentChar != '{') {
                    buffer.append((char) currentChar);
                    currentChar = reader.read();
                }
                if (!buffer.toString().equals("Song")) { //объекты в файле не являются экземплярами класса Song
                    System.out.println("It isn't Song!");
                    System.exit(1);
                }
                String name = "", author = "", genre = "";
                int length = 0;
                currentChar = reader.read();
                while ((char) currentChar != '}') { //считывание имени поля
                    buffer = new StringBuilder();
                    while ((char) currentChar != '=') {
                        buffer.append((char) currentChar);
                        currentChar = reader.read();
                    }
                    currentChar = reader.read();
                    StringBuilder value = new StringBuilder();
                    while ((char) currentChar != ',' && (char) currentChar != '}') { //считывание значения поля
                        value.append((char) currentChar);
                        currentChar = reader.read();
                    }
                    if ((char) currentChar == ',') currentChar = reader.read();
                    switch (buffer.toString()) {
                        case "name":
                            name = value.toString();
                            break;
                        case "author":
                            author = value.toString();
                            break;
                        case "genre":
                            genre = value.toString();
                            break;
                        case "length":
                            length = Integer.parseInt(value.toString());
                            break;
                    }

                }
                album.add(new MusicalNode<Song>(new Song(name, author, genre, length))); //добавление объекта в коллекцию
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("Input/output exception");
            ex.printStackTrace();
            System.exit(1);
        }
        return album;
    }
}



