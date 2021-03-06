// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.agent.Turtle
import org.nlogo.api.{ Syntax, Nobody }
import org.nlogo.nvm.{ Reporter, Context, EngineException }

class _turtle extends Reporter {

  override def syntax =
    Syntax.reporterSyntax(
      Array(Syntax.NumberType),
      Syntax.TurtleType | Syntax.NobodyType)

  override def report(context: Context) =
    report_1(context, argEvalDoubleValue(context, 0))

  def report_1(context: Context, idDouble: Double) = {
    val id = validLong(idDouble)
    if (id != idDouble)
      throw new EngineException(
        context, this, idDouble + " is not an integer")
    val turtle = world.getTurtle(id)
    if (turtle == null) Nobody
    else turtle
  }

}
