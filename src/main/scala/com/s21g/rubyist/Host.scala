package com.s21g.rubyist

import java.net.InetAddress

case class Host(ia:InetAddress) {
  def name    = ia.getHostName
  def address = ia.getHostAddress

  def identity: String = try {
    if (!name.isEmpty) return name
    if (!address.isEmpty) return address
    throw new RuntimeException("Hostname not found: " + toString)
  }
}

object CurrentHost extends Host(InetAddress.getLocalHost)

