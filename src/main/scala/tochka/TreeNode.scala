package tochka

case class TreeNode(value: Int, left: Option[TreeNode], right: Option[TreeNode])

object TreeNodeApp extends App {

  def isSameTree(p: Option[TreeNode], q: Option[TreeNode]): Boolean = {
    if (p.isEmpty && q.isEmpty) true
    else if (p.isEmpty || q.isEmpty) false
    else {
      val pn = p.get
      val qn = q.get
      pn.value == qn.value && isSameTree(pn.left, qn.left) && isSameTree(pn.right, qn.right)
    }
  }

  val simpleP = TreeNode(1, None, None)
  val simpleQ = TreeNode(1, None, None)
  assert(isSameTree(Some(simpleP), Some(simpleQ)))
  val p = TreeNode(1, Some(TreeNode(2, None, None)), None)
  val q = TreeNode(1, None, Some(TreeNode(2, None, None)))
  assert(!isSameTree(Some(p), Some(q)))
}
