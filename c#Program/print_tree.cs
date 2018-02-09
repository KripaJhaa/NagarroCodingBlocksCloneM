using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace print_tree
{


    interface IbinaryTree<T>
        {
            void Add(T val);

            node<T> getRoot(binaryTree<T> b);

        }

    public class node<T>
    {
        public node<T> left, right;
        public T val;

        public node(T val1)
        {
            this.val = val1;
            this.left = null;
            this.right = null;
        }
    }
    

    public class binaryTree<T> : IbinaryTree<T>
    {
        public node<T> root;


        public binaryTree()
        {
            root = null;
        }



        public void Add(T val)
        {
            root = Add_list(root, val);
        }


        public node<T> Add_list(node<T> root, T val)
        {
            node<T> newNode = new node<T>(val);


            if (root == null)
            {
                root = newNode;
            }
            else
            {
                if (root.left == null)
                {
                    root.left = Add_list(root.left, val);
                }
                else
                {
                    root.right = Add_list(root.right, val);
                }

            }
            return root;
        }


        public node<T> getRoot(binaryTree<T> b)
        {
            return b.root;
        }


        public void getPreOrder(node<T> root)
        {
            preOrder(root);
        }


        public void preOrder(node<T> root)
        {


            if (root != null)
            {

                Console.WriteLine(root.val);
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public void LevelOrder(node<T> root)
        {

            Console.WriteLine("\n\n ..............\" Level Order Traversal \"........... \n");
            Queue<node<T>> queue = new Queue<node<T>>();
            queue.Enqueue(root);

            while (queue.Count != 0)
            {
                node<T> node = queue.Dequeue();

                Console.Write(node.val + " ");

                if (node.left != null)
                {
                    queue.Enqueue(node.left);

                }

                if (node.right != null)
                {
                    queue.Enqueue(node.right);

                }
            }

        }


        public void spiralOrder(node<T> root)
        {
            Stack<node<T>> stack1 = new Stack<node<T>>();
            Stack<node<T>> stack2 = new Stack<node<T>>();


            Console.WriteLine("\n\n.................Spiral Order Traversal..............\n");
            stack1.Push(root);

            while (stack1.Count != 0 || stack2.Count != 0)
            {

                while (stack1.Count != 0)
                {
                    node<T> node = stack1.Pop();

                    Console.Write(node.val + " ");

                    if (node.right != null) { stack2.Push(node.right); }
                    if (node.left != null) { stack2.Push(node.left); }

                }

                while (stack2.Count != 0)
                {
                    node<T> node = stack2.Pop();

                    Console.Write(node.val + " ");

                    if (node.left != null) { stack1.Push(node.left); }
                    if (node.right != null) { stack1.Push(node.right); }
                }
            }




        }
    }

     class Program
        {
            static void Main(string[] args)
            {

                binaryTree<int> mytreeHead = new binaryTree<int>();

                mytreeHead.Add( 1);
                mytreeHead.Add( 2);
                mytreeHead.Add( 3);
                mytreeHead.Add( 4);
                mytreeHead.Add( 5);
                mytreeHead.Add( 6);
                mytreeHead.Add( 7);
                mytreeHead.Add( 8);


            //-------------------------------------

            /*
             * 
             *          1
             *       2     3
             *      4 5   6 7
             *    8
             *    
             *    
             * */

            binaryTree<int> head = new binaryTree<int>();

            head.root = new node<int>(1);

            head.root.left = new node<int>(2);
            head.root.right = new node<int>(3);
            head.root.left.left = new node<int>(4);
            head.root.left.right = new node<int>(5);
            head.root.right.left = new node<int>(6);
            head.root.right.right = new node<int>(7);
            head.root.left.left.left = new node<int>(8);



           // Console.WriteLine("..................Preorder Traversal ............\n\n");
            // mytreeHead.getPreOrder(mytreeHead.root);
           // head.getPreOrder(head.root);


            
             head.LevelOrder(head.root);
             head.spiralOrder(head.root);


             Console.Read();
            }

        }



}
/*

        
       2
    4     1 
  6   8 9  10
11 

*/

// 1 2 4 5 8 9 10 16 17 18 20

// 1 2 3 4 5 6 7 8
