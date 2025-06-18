/* Approach
We use a post-order traversal (DFS) and assign one of three states to each node:
1.NOT_COVERED (0): Node is not covered by any camera.
2.HAS_CAMERA (1): Node has a camera.
3.COVERED (2): Node is covered, but doesn’t have a camera.
Logic:
1.If any child is NOT_COVERED, we must put a camera at this node.
2.If any child has a camera, this node is automatically COVERED.
3.Otherwise, this node is NOT_COVERED.
*/

//JAVA Code
class Solution {
    int cameraCount=0;
    public int minCameraCover(TreeNode root) {
        // If root ends up not being covered, we need a camera at root
        if(dfs(root)==0){
        cameraCount++;
        }
        return cameraCount;
    }
    // 0: NOT_COVERED, 1: HAS_CAMERA, 2: COVERED
    public int dfs(TreeNode node){
        if(node==null) return 2;
        int left=dfs(node.left);
        int right=dfs(node.right);
        if(left==0 || right==0){
            cameraCount++;
            return 1;// place camera here
        }
        if(left==1 || right==1){
            return 2;// covered by child
        }
        return 0; // not covered
    }
}
