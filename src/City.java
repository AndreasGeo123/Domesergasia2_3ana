public class City implements CityInterface{

    private int id;
    private String name;
    private int pop;
    private int cases;
    private int i;

    public City(int i){
        this.i=i;
    }



    public City(int id,String name,int pop,int cases){
        this.id = id;
        this.name = name;
        this.pop = pop;
        this.cases = cases;
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPopulation() {
        return pop;
    }

    @Override
    public int getCovidCases() {
        return cases;
    }

    @Override
    public void setID(int ID) {

        System.out.println(id);
    }

    @Override
    public void setName(String name) {

        System.out.println(name);
    }

    @Override
    public void setPopulation(int population) {

        System.out.println(pop);
    }

    @Override
    public void setCovidCases(int CovidCases) {

        System.out.println(cases);
    }

    @Override
    public String  toString(){
        return +id + " " + name + " " + pop + " " + cases;         // prepei na figei apo to interface kai na ftia3w mia stin List moy klasei
    }

    @Override
    public int calculateDensity(){

        return this.cases * 50000 / this.pop;
    }

    public static void sort(ListInterface<City> arr, int size) {
        //int n = arr.length;
         City [] list = new City[size];

         for (int i = 0; i <size; i++) {
             if (i == 0) {
                 list[i] = arr.getFirst();
                 //System.out.println(i);
                 //System.out.println(list[i]);
             }else{
                 list[i]= arr.getNext();
                 //System.out.println(i);
                 //System.out.println(list[i]);
             }
             //if (i==1) System.out.println("se gamaw");
         }

        // Build heap (rearrange array)
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(list, size, i);

        // One by one extract an element from heap
        for (int i = size - 1; i > 0; i--) {
            // Move current root to end
            City temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            // call max heapify on the reduced heap
            heapify(list, i, 0);
        }
        printaregamwtinmanasoy(list,size);
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
     static void heapify(City [] list, int n, int i) {


        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

         if (l < n && list[l].calculateDensity() == list[largest].calculateDensity()) {
             System.out.println(list[l].getName());
             System.out.println(list[largest].getName());
             if (list[l].getName().equals(list[largest].getName())){
                 System.out.println("se gamaw pali");
             }
         }

         if(r <n && list[r].calculateDensity() == list[largest].calculateDensity()) {
             System.out.println(list[l].getName());
             System.out.println(list[largest].getName());
         }




        // If left child is larger than root
        if (l < n && list[l].calculateDensity() < list[largest].calculateDensity()) {
            largest = l;
            //System.out.println(list[l].getName());
        }
        // If right child is larger than largest so far
        if (r < n && list[r].calculateDensity() < list[largest].calculateDensity()) {
            largest = r;
            //System.out.println(list[l].getName());
        }
        // If largest is not root
        if (largest != i) {
            City swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }

        //System.out.println(list);

    }

    public static void printaregamwtinmanasoy(City[] list, int size){

        for (int i=0; i<size; i++) System.out.println(list[i].getName());
    }
}
