public class MyList {
    public String[] arr;
    public int size;

    public MyList(){
        arr = new String[10];
        size = 0;
    }

    public boolean add(String s){ 
        String[] temp = new String[size+1];

        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }

        temp[size] = s;
        arr = temp;
        size++;

        return true;
    }

    public boolean add(int index, String s){
        if (index < 0 || index > size){
            return false;
        }

        String[] temp = new String[size+1];

        for (int i = 0; i < index; i++){
            temp[i] = arr[i];
        }
        temp[index] = s;

        for (int i = index; i < size; i++){ 
            temp[i+1] = arr[i];
        }

        arr = temp;
        size++;
        return true;

    }

    public String get(int index){
        if (index < 0 || index >= size){
            return ("Index out of bounds");
        }

        return arr[index];
    }

    public String set(int index, String s){
        String prevObj = arr[index];
        if (index < 0 || index >= size){
            return ("Index out of bounds");
        }
        arr[index] = s;
        return prevObj;
    }

    public String remove(int index){
        if (index < 0 || index >= size) { 
            return ("Index out of bounds");
        }

        String prevObj = arr[index];
        String[] temp = new String[size-1];

        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }

        for (int i = index + 1; i < size; i++) {
            temp[i - 1] = arr[i]; 
        }

        arr = temp;
        size--;
        return prevObj;
    }

    public int indexOf(String s){
        for (int i = 0; i < size; i++){
            if (arr[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        String toPrint = "[";
        for (int i = 0; i < size; i++) {
            toPrint += arr[i]; 
            if (i < size - 1) { 
                toPrint += ", ";
            }
        }
        toPrint += "]";
        return toPrint;
    }

    public static MyList asList(String... elements) {
        MyList myList = new MyList();
        for (String element : elements) {
            myList.add(element); 
        }
        return myList;
    }

    public static void main(String[] args) {
        MyList myList = MyList.asList("hello", "how", "are", "you");
        myList.add("doing?");
        myList.add(1, "person");
        myList.remove(myList.size-1);
        myList.set(1, "teacher");

        System.out.println(myList.size());
        System.out.println(myList.indexOf("teacher"));
        System.out.println(myList.get(1));
        System.out.println (myList.toString());
    }
}
