using System;
using System.Collections.Generic;

namespace BinarySearchTreeDojo
{
    public class BinarySearchTree
    {
        private Node Root { get; set; }

        private BinarySearchTree(List<int> elements)
        {
            Setup(elements);
        }

        public static BinarySearchTree Build(List<int> elements)
        {
            return new BinarySearchTree(elements);
        }
    
        public Boolean Search(int toFind) {
            // TODO return true if the element has been found, false if its not in the tree.
            var current = Root;
            while (current != null)
            {
                if (toFind == current.Number)
                {
                    return true;
                }
                else
                {
                    current = toFind > current.Number ? current.Right : current.Left;
                }
            }
            return false;
        }

        public void Add(int num) {
            // TODO adds an element. Throws an error if it exist.
            var newNode = new Node(num);
            var current = Root;
            var added = false;

            while (added != true)
            {
                var baseNum = current.Number;
                var greater = num > baseNum;
                var smaller = num < baseNum;
                var leftEmpty = current.Left == null;
                var rightEmpty = current.Right == null;
                var equal = num == baseNum;

                if (equal)
                {
                    throw new ItemAlreadyAdded(num);
                }
                else if (smaller && leftEmpty)
                {
                    current.Left = newNode;
                    added = true;
                }
                else if (greater && rightEmpty)
                {
                    current.Right = newNode;
                    added = true;
                }
                else
                {
                    current = greater ? current.Right : current.Left;
                }
            }
        }

        public void Remove(int toRemove) {
            // TODO removes an element. Throws an error if its not on the tree.
            RemoveFound(Root, toRemove);

            if (Search(toRemove))
            {
                throw new ItemNotOnTree(toRemove);
            }
        }

        private Node RemoveFound(Node found, int toRemove)
        {
            if (toRemove < found.Number)
            {
                found.Left = RemoveFound(found.Left, toRemove);
            }
            else if (toRemove > found.Number)
            {
                found.Right = RemoveFound(found.Right, toRemove);
            }
            else
            {
                if (found.Left == null && found.Right == null)
                {
                    return null;
                }
                else if (found.Left != null && found.Right != null)
                {
                    var predecessor = FindMaximum(found.Left);
                    found.Number = predecessor.Number;

                    found.Left = RemoveFound(found.Left, predecessor.Number);
                }
                else
                {
                    var successor = found.Left != null ? found.Left : found.Right;
                    found = successor;
                }
            }
            return found;
        }

        private Node FindMinimum(Node current)
        {
            while (current.Left != null)
            {
                current = current.Left;
            }
            return current;
        }

        private Node FindMaximum(Node current)
        {
            while (current.Right != null)
            {
                current = current.Right;
            }
            return current;
        }

        private void Setup(List<int> elements)
        {
            elements.Sort();
            var length = elements.Count;
            var odd = length % 2 == 0;
            var index = odd ? (length / 2) - 1 : length / 2;
            Root = new Node(elements[index]);
            elements.RemoveAt(index);

            FillTree(elements);
        }

        private void FillTree(List<int> elements)
        {
            foreach (var num in elements)
            {
                Add(num);
            }
        }

        private partial class Node
        {
            public Node Left { get; set; }
            public Node Right { get; set; }
            public int Number { get; set; }

            public string RequestNodeData => $"Left: {Left}, Right: {Right}, Number: {Number}";

            public Node(int num)
            {
                Number = num;
            }
        }
    }

}
