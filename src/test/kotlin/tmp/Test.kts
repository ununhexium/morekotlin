import com.google.common.collect.Lists

Lists.cartesianProduct(
    ('C'..'I').toList(),
    (1..12).toList(),
    (' '..'/').toList()
).map {  println(it) }