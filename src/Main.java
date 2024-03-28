import java.io.File;
import java.util.concurrent.ForkJoinPool;


public class Main {

    public static void main(String[] args) {
//        System.out.println(getHumanReadableSize(240640));
//        System.exit(0);
//
//        System.out.println(getSizeFromHumanReadable("235K"));
//        System.exit(0);

        //        MyThread thread = new MyThread(1);
//        MyThread thread2 = new MyThread(2);
//        thread.start();
//        thread2.start();


//        for (int i = 0; i < args.length; i++) {
//            System.out.println(i + "=>" + args[i]);
//        }
//
//        System.exit(0);


//        String folderPath = "D:\\Tanki";
//        long sizeLimit = 50 * 1024 * 1024;

//        String [] argums = {"-d","d/Films", "-l", "54G"};
//        for (String arg : args)
//        {
//            System.out.println(">>" + arg + "<<");
//        }

        ParametrsBag bag = new ParametrsBag(args);

        String folderPath = bag.getPath();
        long sizeLimit = bag.getLimit();

        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);

        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool poll = new ForkJoinPool();
        poll.invoke(calculator);

        System.out.println(root);

//        System.out.println(getFolderSize(file));
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " miiliseconds");

//        Показать директорию проекта:
//        System.out.println(System.getProperties().get("user.dir"));
    }

}