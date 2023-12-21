package be.odisee.colors.data

import be.odisee.colors.model.ColorCategory
import be.odisee.colors.model.HTMLColor

object DataSource {

    fun getColors(): List<HTMLColor> {
        return listOf(
            HTMLColor("INDIANRED", 0xFFCD5C5C, listOf(ColorCategory.RED, ColorCategory.BROWN)),
            HTMLColor(
                "LIGHTCORAL",
                0xFFF08080,
                listOf(
                    ColorCategory.RED,
                    ColorCategory.PINK,
                )
            ),
            HTMLColor(
                "SALMON",
                0xFFFA8072,
                listOf(
                    ColorCategory.RED,
                    ColorCategory.PINK,
                    ColorCategory.ORANGE,
                )
            ),
            HTMLColor(
                "DARKSALMON",
                0xFFE9967A,
                listOf(
                    ColorCategory.RED,
                    ColorCategory.PINK,
                    ColorCategory.ORANGE,

                    )
            ),
            HTMLColor(
                "LIGHTSALMON",
                0xFFFFA07A,
                listOf(
                    ColorCategory.RED,
                    ColorCategory.PINK,
                    ColorCategory.ORANGE,

                    )
            ),
            HTMLColor("CRIMSON", 0xFFDC143C, listOf(ColorCategory.RED)),
            HTMLColor("RED", 0xFFFF0000, listOf(ColorCategory.RED)),
            HTMLColor("DARKRED", 0xFF8B0000, listOf(ColorCategory.RED)),
            HTMLColor("PINK", 0xFFFFC0CB, listOf(ColorCategory.PINK)),
            HTMLColor("LIGHTPINK", 0xFFFFB6C1, listOf(ColorCategory.PINK)),
            HTMLColor("HOTPINK", 0xFFFF69B4, listOf(ColorCategory.PINK)),
            HTMLColor("DEEPPINK", 0xFFFF1493, listOf(ColorCategory.PINK)),
            HTMLColor(
                "MEDIUMVIOLETRED",
                0xFFC71585,
                listOf(
                    ColorCategory.PINK,
                    ColorCategory.PURPLE,

                    )
            ),
            HTMLColor(
                "PALEVIOLETRED",
                0xFFDB7093,
                listOf(ColorCategory.PINK)
            ),
            HTMLColor("CORAL", 0xFFFF7F50, listOf(ColorCategory.ORANGE)),
            HTMLColor("TOMATO", 0xFFFF6347, listOf(ColorCategory.ORANGE, ColorCategory.RED)),
            HTMLColor("ORANGERED", 0xFFFF4500, listOf(ColorCategory.ORANGE, ColorCategory.RED)),
            HTMLColor("DARKORANGE", 0xFFFF8C00, listOf(ColorCategory.ORANGE)),
            HTMLColor("ORANGE", 0xFFFFA500, listOf(ColorCategory.ORANGE)),
            HTMLColor("GOLD", 0xFFFFD700, listOf(ColorCategory.YELLOW)),
            HTMLColor("YELLOW", 0xFFFFFF00, listOf(ColorCategory.YELLOW)),
            HTMLColor("LIGHTYELLOW", 0xFFFFFFE0, listOf(ColorCategory.YELLOW)),
            HTMLColor("LEMONCHIFFON", 0xFFFFFACD, listOf(ColorCategory.YELLOW)),
            HTMLColor(
                "LIGHTGOLDENRODYELLOW",
                0xFFFAFAD2,
                listOf(
                    ColorCategory.YELLOW,

                    )
            ),
            HTMLColor("PAPAYAWHIP", 0xFFFFEFD5, listOf(ColorCategory.PINK)),
            HTMLColor("MOCCASIN", 0xFFFFE4B5, listOf(ColorCategory.PINK)),
            HTMLColor(
                "PEACHPUFF",
                0xFFFFDAB9,
                listOf(ColorCategory.PINK, ColorCategory.ORANGE)
            ),
            HTMLColor(
                "PALEGOLDENROD",
                0xFFEEE8AA,
                listOf(
                    ColorCategory.YELLOW,

                    )
            ),
            HTMLColor(
                "KHAKI",
                0xFFF0E68C,
                listOf(ColorCategory.YELLOW)
            ),
            HTMLColor(
                "DARKKHAKI",
                0xFFBDB76B,
                listOf(
                    ColorCategory.YELLOW,

                    )
            ),
            HTMLColor("LAVENDER", 0xFFE6E6FA, listOf(ColorCategory.PURPLE)),
            HTMLColor("THISTLE", 0xFFD8BFD8, listOf(ColorCategory.PURPLE)),
            HTMLColor("PLUM", 0xFFDDA0DD, listOf(ColorCategory.PURPLE)),
            HTMLColor(
                "VIOLET",
                0xFFEE82EE,
                listOf(ColorCategory.PURPLE, ColorCategory.PINK)
            ),
            HTMLColor("ORCHID", 0xFFDA70D6, listOf(ColorCategory.PURPLE)),
            HTMLColor("FUCHSIA", 0xFFFF00FF, listOf(ColorCategory.PURPLE, ColorCategory.PINK)),
            HTMLColor(
                "MAGENTA",
                0xFFFF00FF,
                listOf(ColorCategory.PURPLE, ColorCategory.PINK)
            ),
            HTMLColor(
                "MEDIUMORCHID",
                0xFFBA55D3,
                listOf(ColorCategory.PURPLE)
            ),
            HTMLColor("MEDIUMPURPLE", 0xFF9370DB, listOf(ColorCategory.PURPLE)),
            HTMLColor(
                "REBECCAPURPLE",
                0xFF663399,
                listOf(ColorCategory.PURPLE, ColorCategory.BLUE)
            ),
            HTMLColor(
                "BLUEVIOLET",
                0xFF8A2BE2,
                listOf(ColorCategory.PURPLE, ColorCategory.BLUE)
            ),
            HTMLColor(
                "DARKVIOLET",
                0xFF9400D3,
                listOf(ColorCategory.PURPLE)
            ),
            HTMLColor(
                "DARKORCHID",
                0xFF9932CC,
                listOf(ColorCategory.PURPLE)
            ),
            HTMLColor(
                "DARKMAGENTA",
                0xFF8B008B,
                listOf(ColorCategory.PURPLE)
            ),
            HTMLColor("PURPLE", 0xFF800080, listOf(ColorCategory.PURPLE)),
            HTMLColor("INDIGO", 0xFF4B0082, listOf(ColorCategory.PURPLE, ColorCategory.BLUE)),
            HTMLColor(
                "SLATEBLUE",
                0xFF6A5ACD,
                listOf(ColorCategory.PURPLE, ColorCategory.BLUE)
            ),
            HTMLColor(
                "DARKSLATEBLUE",
                0xFF483D8B,
                listOf(
                    ColorCategory.PURPLE,
                    ColorCategory.BLUE,

                    )
            ),
            HTMLColor(
                "MEDIUMSLATEBLUE",
                0xFF7B68EE,
                listOf(
                    ColorCategory.PURPLE,
                    ColorCategory.BLUE,

                    )
            ),
            HTMLColor("GREENYELLOW", 0xFFADFF2F, listOf(ColorCategory.GREEN, ColorCategory.YELLOW)),
            HTMLColor("CHARTREUSE", 0xFF7FFF00, listOf(ColorCategory.GREEN)),
            HTMLColor("LAWNGREEN", 0xFF7CFC00, listOf(ColorCategory.GREEN)),
            HTMLColor("LIME", 0xFF00FF00, listOf(ColorCategory.GREEN)),
            HTMLColor("LIMEGREEN", 0xFF32CD32, listOf(ColorCategory.GREEN)),
            HTMLColor("PALEGREEN", 0xFF98FB98, listOf(ColorCategory.GREEN)),
            HTMLColor("LIGHTGREEN", 0xFF90EE90, listOf(ColorCategory.GREEN)),
            HTMLColor(
                "MEDIUMSPRINGGREEN",
                0xFF00FA9A,
                listOf(ColorCategory.GREEN)
            ),
            HTMLColor("SPRINGGREEN", 0xFF00FF7F, listOf(ColorCategory.GREEN)),
            HTMLColor(
                "MEDIUMSEAGREEN",
                0xFF3CB371,
                listOf(ColorCategory.GREEN)
            ),
            HTMLColor("SEAGREEN", 0xFF2E8B57, listOf(ColorCategory.GREEN)),
            HTMLColor("FORESTGREEN", 0xFF228B22, listOf(ColorCategory.GREEN)),
            HTMLColor("GREEN", 0xFF008000, listOf(ColorCategory.GREEN)),
            HTMLColor("DARKGREEN", 0xFF006400, listOf(ColorCategory.GREEN)),
            HTMLColor("YELLOWGREEN", 0xFF9ACD32, listOf(ColorCategory.GREEN, ColorCategory.YELLOW)),
            HTMLColor("OLIVEDRAB", 0xFF6B8E23, listOf(ColorCategory.GREEN)),
            HTMLColor("OLIVE", 0xFF6B8E23, listOf(ColorCategory.GREEN)),
            HTMLColor(
                "DARKOLIVEGREEN",
                0xFF556B2F,
                listOf(ColorCategory.GREEN)
            ),
            HTMLColor(
                "MEDIUMAQUAMARINE",
                0xFF66CDAA,
                listOf(
                    ColorCategory.GREEN,
                    ColorCategory.BLUE,

                    )
            ),
            HTMLColor(
                "DARKSEAGREEN",
                0xFF8FBC8B,
                listOf(ColorCategory.GREEN)
            ),
            HTMLColor(
                "LIGHTSEAGREEN",
                0xFF20B2AA,
                listOf(
                    ColorCategory.GREEN,
                    ColorCategory.BLUE,


                    )
            ),
            HTMLColor(
                "DARKCYAN",
                0xFF008B8B,
                listOf(
                    ColorCategory.GREEN,
                    ColorCategory.BLUE,

                    )
            ),
            HTMLColor("TEAL", 0xFF008080, listOf(ColorCategory.GREEN, ColorCategory.BLUE)),
            HTMLColor("AQUA", 0xFF00FFFF, listOf(ColorCategory.BLUE)),
            HTMLColor("CYAN", 0xFF00FFFF, listOf(ColorCategory.BLUE)),
            HTMLColor(
                "LIGHTCYAN",
                0xFFE0FFFF,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor(
                "PALETURQUOISE",
                0xFFAFEEEE,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor("AQUAMARINE", 0xFF7FFFD4, listOf(ColorCategory.BLUE)),
            HTMLColor("TURQUOISE", 0xFF40E0D0, listOf(ColorCategory.BLUE)),
            HTMLColor(
                "MEDIUMTURQUOISE",
                0xFF48D1CC,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor(
                "DARKTURQUOISE",
                0xFF00CED1,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor("CADETBLUE", 0xFF5F9EA0, listOf(ColorCategory.BLUE, ColorCategory.GRAY)),
            HTMLColor("STEELBLUE", 0xFF4682B4, listOf(ColorCategory.BLUE)),
            HTMLColor(
                "LIGHTSTEELBLUE",
                0xFFB0C4DE,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor("POWDERBLUE", 0xFFB0E0E6, listOf(ColorCategory.BLUE)),
            HTMLColor("LIGHTBLUE", 0xFFADD8E6, listOf(ColorCategory.BLUE)),
            HTMLColor("SKYBLUE", 0xFF87CEEB, listOf(ColorCategory.BLUE)),
            HTMLColor(
                "LIGHTSKYBLUE",
                0xFF87CEFA,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor(
                "DEEPSKYBLUE",
                0xFF00BFFF,
                listOf(ColorCategory.BLUE)
            ),
            HTMLColor("DODGERBLUE", 0xFF1E90FF, listOf(ColorCategory.BLUE)),
            HTMLColor("CORNFLOWERBLUE", 0xFF6495ED, listOf(ColorCategory.BLUE)),
            HTMLColor("ROYALBLUE", 0xFF4169E1, listOf(ColorCategory.BLUE)),
            HTMLColor("BLUE", 0xFF0000FF, listOf(ColorCategory.BLUE)),
            HTMLColor("MEDIUMBLUE", 0xFF0000CD, listOf(ColorCategory.BLUE)),
            HTMLColor("DARKBLUE", 0xFF00008B, listOf(ColorCategory.BLUE)),
            HTMLColor("NAVY", 0xFF00008B, listOf(ColorCategory.BLUE)),
            HTMLColor("MIDNIGHTBLUE", 0xFF191970, listOf(ColorCategory.BLUE)),
            HTMLColor("CORNSILK", 0xFFFFF8DC, listOf(ColorCategory.BROWN)),
            HTMLColor("BLANCHEDALMOND", 0xFFFFEBCD, listOf(ColorCategory.BROWN)),
            HTMLColor("BISQUE", 0xFFFFE4C4, listOf(ColorCategory.BROWN)),
            HTMLColor("NAVAJOWHITE", 0xFFFFDEAD, listOf(ColorCategory.BROWN)),
            HTMLColor("WHEAT", 0xFFF5DEB3, listOf(ColorCategory.BROWN)),
            HTMLColor("BURLYWOOD", 0xFFDEB887, listOf(ColorCategory.BROWN)),
            HTMLColor("TAN", 0xFFD2B48C, listOf(ColorCategory.BROWN)),
            HTMLColor("ROSYBROWN", 0xFFBC8F8F, listOf(ColorCategory.BROWN)),
            HTMLColor("SANDYBROWN", 0xFFF4A460, listOf(ColorCategory.BROWN, ColorCategory.ORANGE)),
            HTMLColor(
                "GOLDENROD",
                0xFFDAA520,
                listOf(ColorCategory.BROWN, ColorCategory.ORANGE)
            ),
            HTMLColor(
                "DARKGOLDENROD",
                0xFFB8860B,
                listOf(
                    ColorCategory.BROWN,
                    ColorCategory.ORANGE,

                    )
            ),
            HTMLColor("PERU", 0xFFCD853F, listOf(ColorCategory.BROWN, ColorCategory.ORANGE)),
            HTMLColor("CHOCOLATE", 0xFFD2691E, listOf(ColorCategory.BROWN, ColorCategory.ORANGE)),
            HTMLColor("SADDLEBROWN", 0xFF8B4513, listOf(ColorCategory.BROWN)),
            HTMLColor("SIENNA", 0xFFA0522D, listOf(ColorCategory.BROWN)),
            HTMLColor("BROWN", 0xFFA52A2A, listOf(ColorCategory.BROWN, ColorCategory.RED)),
            HTMLColor("MAROON", 0xFF800000, listOf(ColorCategory.BROWN, ColorCategory.RED)),
            HTMLColor("WHITE", 0xFFFFFFFF, listOf(ColorCategory.WHITE)),
            HTMLColor("SNOW", 0xFFFFFAFA, listOf(ColorCategory.WHITE)),
            HTMLColor("HONEYDEW", 0xFFF0FFF0, listOf(ColorCategory.WHITE)),
            HTMLColor("MINTCREAM", 0xFFF5FFFA, listOf(ColorCategory.WHITE)),
            HTMLColor("AZURE", 0xFFF0FFFF, listOf(ColorCategory.WHITE)),
            HTMLColor("ALICEBLUE", 0xFFF0F8FF, listOf(ColorCategory.WHITE)),
            HTMLColor("GHOSTWHITE", 0xFFF8F8FF, listOf(ColorCategory.WHITE)),
            HTMLColor("WHITESMOKE", 0xFFF5F5F5, listOf(ColorCategory.WHITE)),
            HTMLColor("SEASHELL", 0xFFFFF5EE, listOf(ColorCategory.WHITE, ColorCategory.PINK)),
            HTMLColor("BEIGE", 0xFFF5F5DC, listOf(ColorCategory.WHITE)),
            HTMLColor("OLDLACE", 0xFFFDF5E6, listOf(ColorCategory.WHITE)),
            HTMLColor("FLORALWHITE", 0xFFFDF5E6, listOf(ColorCategory.WHITE)),
            HTMLColor("IVORY", 0xFFFFFFF0, listOf(ColorCategory.WHITE)),
            HTMLColor("ANTIQUEWHITE", 0xFFFAEBD7, listOf(ColorCategory.WHITE)),
            HTMLColor("LINEN", 0xFFFAF0E6, listOf(ColorCategory.WHITE)),
            HTMLColor(
                "LAVENDERBLUSH",
                0xFFFFF0F5,
                listOf(ColorCategory.WHITE, ColorCategory.PINK)
            ),
            HTMLColor("MISTYROSE", 0xFFFFE4E1, listOf(ColorCategory.WHITE, ColorCategory.PINK)),
            HTMLColor("GAINSBORO", 0xFFDCDCDC, listOf(ColorCategory.GRAY)),
            HTMLColor("LIGHTGRAY", 0xFFD3D3D3, listOf(ColorCategory.GRAY)),
            HTMLColor("SILVER", 0xFFC0C0C0, listOf(ColorCategory.GRAY)),
            HTMLColor("DARKGRAY", 0xFFA9A9A9, listOf(ColorCategory.GRAY)),
            HTMLColor("GRAY", 0xFF808080, listOf(ColorCategory.GRAY)),
            HTMLColor("DIMGRAY", 0xFF696969, listOf(ColorCategory.GRAY)),
            HTMLColor(
                "LIGHTSLATEGRAY",
                0xFF778899,
                listOf(ColorCategory.GRAY)
            ),
            HTMLColor("SLATEGRAY", 0xFF708090, listOf(ColorCategory.GRAY)),
            HTMLColor(
                "DARKSLATEGRAY",
                0xFF2F4F4F,
                listOf(ColorCategory.GRAY)
            ),
            HTMLColor("BLACK", 0xFF000000, listOf(ColorCategory.BLACK)),
        )
    }
}