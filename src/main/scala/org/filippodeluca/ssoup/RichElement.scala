/*
 * Copyright 2013 Filippo De Luca - me@filippodeluca.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.filippodeluca.ssoup

import org.jsoup.nodes.Element

class RichElement(value: Element) extends RichNode(value) {

  def getElementById(id: String): Option[Element] = value.getElementById(id) match {
    case null => None
    case x => Some(x)
  }

  def getElementsByTag(tag: String): Iterable[Element] = SSoup.enrichElements(value.getElementsByTag(tag))

  def getElementsByClass(tag: String): Iterable[Element] = SSoup.enrichElements(value.getElementsByClass(tag))

  def getElementsByAttribute(tag: String): Iterable[Element] = SSoup.enrichElements(value.getElementsByAttribute(tag))

  def getElementsByAttributeStarting(tag: String): Iterable[Element] = SSoup.enrichElements(value.getElementsByAttributeStarting(tag))

  def getElementsByAttributeValue(k: String, v: String): Iterable[Element] = SSoup.enrichElements(value.getElementsByAttributeValue(k, v))

  def apply(name: String): Option[String] = Option(value.attr(name))

}
