 public class List<City> implements ListInterface<City> {

        private Node <City> head = null;
        private Node <City> tail = null;

        /**
         * Default constructor
         */
        public List() {
        }

        /**
         * Determine whether list is empty
         *
         * @return true if list is empty
         */
        @Override
        public boolean isEmpty() {

            return head == null;
        }

        /**
         * Inserts the data at the front of the list
         *
         * @param data the inserted data
         */
        @Override
        public void insertAtFront(City data) {

            Node <City> n = new Node<>(data);

            if (isEmpty()) {
                head = n;
                tail = n;
            } else {
                n.setNext(head);
                head = n;
            }
        }

        /**
         * Inserts the data at the end of the list
         *
         * @param data the inserted item
         */
        @Override
        public void insertAtBack(City data) {

            Node <City> n = new Node<>(data);

            if (isEmpty()) {
                head = n;
                tail = n;
                head.setPrev(null);
                tail.setNext(null);
            } else {
                tail.setNext(n);
                n.setPrev(tail);
                tail = n;
                tail.setNext(n);
            }
        }


        @Override
        public City removeFromFront()  {

            //if (isEmpty())
            //throw new EmptyListException();

            City data = head.getData();

            if (head == tail)
                head = tail = null;
            else
                head = head.getNext();

            return data;
        }


        @Override
        public City removeFromBack()  {

            //if (isEmpty())
            //throw new EmptyListException();

            City data = tail.getData();

            if (head == tail)
                head = tail = null;
            else {
                Node <City> iterator = head;
                while (iterator.getNext() != tail)
                    iterator = iterator.getNext();

                iterator.setNext(null);
                tail = iterator;
            }

            return data;
        }


        @Override
        public City  getFirst(){

            return head.data;
        }

        @Override
        public String toString() {

            if (isEmpty()) {
                return "List is empty :(";
            }

            Node current = head;

            StringBuilder ret = new StringBuilder();

            // while not at end of list, output current node's data
            ret.append("HEAD -> ");

            while (current != null) {
                ret.append(current.data.toString());

                if (current.getNext() != null)
                    ret.append(" -> ");

                current = current.next;
            }

            ret.append(" <- TAIL");

            return ret.toString();
        }

        @Override
        public City getNext(){
            head = head.getNext();
            return head.data;
        }


        @Override
        public City getPrev(){
            head = head.getPrev();
            return head.data;
        }
}
