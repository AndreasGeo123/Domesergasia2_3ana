 public class List<T> implements ListInterface<T> {

        private Node <T> head = null;
        private Node <T> tail = null;

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
        public void insertAtFront(T data) {

            Node <T> n = new Node<>(data);

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
        public void insertAtBack(T data) {

            Node <T> n = new Node<>(data);

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
        public T removeFromFront()  {

            //if (isEmpty())
            //throw new EmptyListException();

            T data = head.getData();

            if (head == tail)
                head = tail = null;
            else
                head = head.getNext();

            return data;
        }


        @Override
        public T removeFromBack()  {

            //if (isEmpty())
            //throw new EmptyListException();

            T data = tail.getData();

            if (head == tail)
                head = tail = null;
            else {
                Node <T> iterator = head;
                while (iterator.getNext() != tail)
                    iterator = iterator.getNext();

                iterator.setNext(null);
                tail = iterator;
            }

            return data;
        }


        @Override
        public T  getFirst(){

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
        public T getNext(){
            head = head.getNext();
            return head.data;
        }


        @Override
        public T getPrev(){
            head = head.getPrev();
            return head.data;
        }
}
