/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> leftQueue = new LinkedList<>();
        LinkedList<TreeNode> rightQueue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        TreeNode currentNode;
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while ((!leftQueue.isEmpty()) && (!rightQueue.isEmpty())) {
            if (leftQueue.isEmpty() || rightQueue.isEmpty()) {
                return false;
            }
            TreeNode currentLeft = leftQueue.poll();
            TreeNode currentRight = rightQueue.poll();
            if (currentLeft == null && currentRight == null) {
                continue;
            }
            if (currentLeft == null || currentRight == null) {
                return false;
            }
            if (currentLeft.val != currentRight.val) {
                return false;
            }
            leftQueue.add(currentLeft.left);
            leftQueue.add(currentLeft.right);
            rightQueue.add(currentRight.right);
            rightQueue.add(currentRight.left);
            
        }
        return true;
    }
}

public class SymmetricTreeIter {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            boolean ret = new Solution().isSymmetric(root);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}