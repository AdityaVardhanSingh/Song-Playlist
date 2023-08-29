package com.songs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Main {

    private static ArrayList<Albums> albums =new ArrayList<>();

    public static void main(String[] args) {

        Albums album = new Albums("Album1","AC/DC");
        album.addSong("TNT",4.5);
        album.addSong("Highway to Hell",3.5);
        album.addSong("Thunderstorm",5);
        albums.add(album);

        album = new Albums ("Album2", "Eminem");

        album.addSong("Rap God", 4.5);
        album.addSong("Not Afraid", 3.5);
        album.addSong("Lose yourself", 4.5);

        albums.add(album);
        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT",playlist_1);
        albums.get(0).addToPlayList("Highway to Hell",playlist_1);
        albums.get(1).addToPlayList("Rap God",playlist_1);
        albums.get(1).addToPlayList("Lose yourself",playlist_1);

        Play(playlist_1);
    }
    private static void Play(LinkedList<Song>playlist){
        Scanner sc= new Scanner(System.in);
        boolean quit =false;
        boolean forward =true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size()==0){
            System.out.println("This playlist has no songs");
        }
        else{
            System.out.println("Now playing"+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action =sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1:
                    if(forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;

                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing"+ listIterator.next().toString());
                    }
                    else{
                        System.out.println("no song availble, reached ot the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing"+ listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are the first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        }
                        else {
                            System.out.println(" we are at the start of the list");
                        }


                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing"+ listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we have reached to the end of list");
                        }

                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing"+ listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            if(listIterator.hasPrevious())
                                System.out.println("now playing"+ listIterator.previous().toString());
                        }
                    }

            }
        }

    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0- to quit\n"+
                "1- To play next song\n"+
                "2- To play previous song\n"+
                "3- To replay the current song\n"+
                "4- List of all song\n"+
                "5- Print all the available options\n"+
                "6- Delete current song");
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator= playlist.iterator();
        System.out.println("______________");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________");
    }
}
