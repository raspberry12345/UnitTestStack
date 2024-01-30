/**
 * Hello world!
 *
 */
public class Stack
{
    private StackItem tail;
    private StackItem head;

    //globale variable zählt elemente im Stack
    private int size = 0;
    public StackItem getHead() {
        return head;
    }

    public void setHead(StackItem tail) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public StackItem getTail() {
        return tail;
    }

    // start push method
    public void push(int data) {

        StackItem element = new StackItem();
        element.setData(data);
        element.setNext(null);


        if(tail == null){
            tail = element;
            head = element;
        }else{
            StackItem e = tail;
            while(e.getNext() != null){
                e = e.getNext();
            }
            e.setNext(element);
            head = element;
        }
        size++;
    }
    // end push method


    // start size() method
    public int size() {
        return size;
    }
    // end size() method


    //start pop() method
    public int pop() throws Exception {
        if (tail == null){
            throw new Exception("empty list");
        }else{

            int position = size -1;
            StackItem runElement = tail;

            int infoElement = -1;
            if(position == 0){
                infoElement = runElement.getData();
                runElement = runElement.getNext();

                tail = runElement;
            }

            else if(position == size - 1){
                    int counter = 0;
                    do {
                        if (position-1 == counter){
                            infoElement = runElement.getNext().getData();
                            runElement.setNext(null);

                        }
                        counter++;
                        if (runElement.getNext() != null){
                            runElement = runElement.getNext();

                        }
                        head = runElement;
                    }while(runElement.getNext() != null);
                }else{
                    infoElement=0;
                }
                size--;
                return infoElement;
        }
    }
    //end pop() method



    //start peek() methode
    public StackItem peek() throws Exception {
        if (tail == null){
            throw new Exception();
        } else{
            StackItem runElement = tail;
            StackItem infoElement;
            do {
                if (runElement.getNext() != null){
                    runElement = runElement.getNext();
                }
            }while(runElement.getNext() != null);
            infoElement = runElement;
            return infoElement;
        }
    }
    //end peek() methode


    //start pop() multiple elements
    public int[] pop(int amount) throws Exception {
        if(amount > size()){
            throw new IllegalArgumentException("entfernen von elementen welche nicht existieren");
        }else{
            int arrayOfElementsData[] = new int[amount];

            int position = size - amount;
            size = size - amount;
            StackItem runElement = tail;
            int count = 1;
            int countArray =0;

            do{
                if (position < count){
                    arrayOfElementsData[countArray] = runElement.getData();
                    countArray++;
                }
                runElement = runElement.getNext();
                count++;
                if (runElement.getNext() == null){
                    arrayOfElementsData[countArray] = runElement.getData();
                }
            }while(runElement.getNext() != null);
            //nochmal durchlaufen und elemente löschen = null setzen
            runElement = tail;
            count = 1;
            do{
                if (count == position){
                    head = runElement;
                    runElement.setNext(null);

                }
                count++;
                if (runElement.getNext() != null){
                    runElement = runElement.getNext();
                }
            }while(runElement.getNext() != null);
            return arrayOfElementsData;
        }
    }
    //end pop() multiple elements

}