package com.joshzana;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * A tree with nodes that have LinkedLists of children
 */
public class Tree
{
    public static class Node
    {
        public Node(int value)
        {
            mValue = value;
        }

        public void addChild(Node n)
        {
            mChildNodes.add(n);
        }

        private final List<Node> mChildNodes = new ArrayList<>();
        private final int mValue;

        @Override
        public String toString()
        {
            return String.valueOf(mValue);
        }
    }

    private final Node mRoot;

    public Tree(Node root)
    {
        mRoot = root;
    }

    public void breadthFirstTraverse(Consumer<Node> handler)
    {
        final Queue<Node> mQueue = new LinkedList<>();

        // Add to tail
        mQueue.offer(mRoot);

        while (!mQueue.isEmpty())
        {
            // remove from head
            final Node n = mQueue.remove();

            // call handler
            handler.accept(n);

            // add to tail
            n.mChildNodes.forEach(n2 -> mQueue.offer(n2));
        }
    }

    public void depthFirstTraversal(Consumer<Node> handler)
    {
        final Stack<Node> mDeque = new Stack<>();

        // push on top of stack
        mDeque.push(mRoot);

        while (!mDeque.isEmpty())
        {
            // pop from top of stack
            final Node currentNode = mDeque.pop();

            // call handler
            handler.accept(currentNode);

            // push children onto top of stack in reverse order
            for (int i = currentNode.mChildNodes.size() - 1; i >= 0; i--)
            {
                mDeque.push(currentNode.mChildNodes.get(i));
            }
        }
    }

    public void depthFirstTraversalRecursive(Consumer<Node> handler)
    {
        recurse(mRoot, handler);
    }

    private void recurse(Node root, Consumer<Node> handler)
    {
        handler.accept(root);
        root.mChildNodes.forEach(child->recurse(child, handler));
    }
}
