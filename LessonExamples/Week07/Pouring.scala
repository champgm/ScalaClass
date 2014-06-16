class Pouring(capacity: Vector[Int]) {

  //States - vector of integers
  type State = Vector[Int] //I hate how they keep doing this kind of stuff
  val initialState = capacity.map(x => 0)

  //Moves - 
  trait Move {
    def change(state: State): State
  }

  case class Empty(glass: Int) extends Move {
    def change(state: State): State = {
      state.updated(glass, 0)
    }
  }
  case class Fill(glass: Int) extends Move {
    def change(state: State): State = {
      state.updated(glass, capacity(glass))
    }
  }
  //This is the complicated one.
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from).min(capacity(to) - state(to))
      state.updated(from, state(from) - amount).updated(to, state(to) + amount)
    }
  }

  val glasses = 0 until capacity.length
  val moves =
    (for { g <- glasses } yield Empty(g)) ++
      (for { g <- glasses } yield Fill(g)) ++
      (for { from <- glasses; to <- glasses if from != to } yield Pour(from, to))

  //Paths
  class Path(history: List[Move], val endState: State) {
    //def endState: State = history.foldRight(initialState)(_ change _)
    //    private def trackState(xs: List[Move]): State = xs match {
    //      case Nil => initialState
    //      case move :: xs1 => move.change(trackState(xs1))
    //    }
    def extend(move: Move) = new Path(move :: history, move.change(endState))
    override def toString = history.reverse.mkString(" ") + "-->" + endState
  }

  val initialPath = new Path(Nil, initialState)

  //this is similar to the "From" for integers that returns all integers between two

  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
    if (paths.isEmpty) Stream.empty
    else {
      val morePaths = for {
        path <- paths
        nextPath <- moves.map(path.extend)
        if (!explored.contains(nextPath.endState))
      } yield nextPath
      paths #:: from(morePaths, explored ++ morePaths.map(_.endState))
    }
  }

  val pathSets = from(Set(initialPath), Set(initialState))

  def solution(target: Int): Stream[Path] = {
    for {
      pathSet <- pathSets
      path <- pathSet
      if (path.endState.contains(target))
    } yield path
  }
}