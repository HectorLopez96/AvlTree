public class Menu {
    AvlTree tree = new AvlTree();
    int option;
    public void AvlTreeMenu(){
        do {
            terminal.clearScreen();
            terminal.decorate();
            terminal.showMessage("\nSelecciona una opcion:\n");
            terminal.showMessage("1. inserta un nodo");
            terminal.showMessage("2. remueve todos los nodos");
            terminal.showMessage("3. muestra el arbol en Post order");
            terminal.showMessage("4. muestra el arbol en Pre order");
            terminal.showMessage("5. muestra el arbol en In order");
            terminal.showMessage("6. salir");
            terminal.decorate();
            option = terminal.askNumber("ingrese un numero");
            switch (option) {
                case 1 -> tree.insertElement(terminal.askNumber("Puede ingresar maximo 5 elementos para el arbol"));
                case 2 -> tree.removeAll();
                case 3 -> tree.postorderTraversal();
                case 4 -> tree.preorderTraversal();
                case 5 -> tree.inorderTraversal();
                default -> System.out.println(" Gracias por su tiempo ");
            }
        } while (option != 6);
    }
}

