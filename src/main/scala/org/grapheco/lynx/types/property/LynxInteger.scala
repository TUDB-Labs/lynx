package org.grapheco.lynx.types.property

import org.grapheco.lynx.types.LynxValue
import org.opencypher.v9_0.util.symbols.{CTInteger, IntegerType}

/**
 * @ClassName LynxInteger
 * @Description TODO
 * @Author huchuan
 * @Date 2022/4/1
 * @Version 0.1
 */
case class LynxInteger(v: Long) extends LynxNumber {
  def value: Long = v

  def number: Number = v

  def +(that: LynxNumber): LynxNumber = {
    that match {
      case LynxInteger(v2) => LynxInteger(v + v2)
      case LynxFloat(v2) => LynxFloat(v + v2)
    }
  }

  def -(that: LynxNumber): LynxNumber = {
    that match {
      case LynxInteger(v2) => LynxInteger(v - v2)
      case LynxFloat(v2) => LynxFloat(v - v2)
    }
  }

  override def >(lynxValue: LynxValue): Boolean = this.value > lynxValue.asInstanceOf[LynxInteger].value

  override def >=(lynxValue: LynxValue): Boolean = this.value >= lynxValue.asInstanceOf[LynxInteger].value

  override def <(lynxValue: LynxValue): Boolean = this.value < lynxValue.asInstanceOf[LynxInteger].value

  override def <=(lynxValue: LynxValue): Boolean = this.value <= lynxValue.asInstanceOf[LynxInteger].value

  def lynxType: IntegerType = CTInteger
}
