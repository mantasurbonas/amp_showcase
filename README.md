# selected samples of Automated Modernization Pipeline  

## FastJSON by alibaba.com

The original file ```PrimitiveArraySerializer``` had a cognitive complexity of 46; a CodeLLama-powered AMP reduced the complexity to 19
(by 58,7%)

[diff](https://github.com/mantasurbonas/amp_showcase/commit/5510937a0c9209b9d3929b942d2b9863ba65f162) [original](https://github.com/mantasurbonas/amp_showcase/blob/2592e1205e02101dc0a5e335a4c5bf16ddf08220/com.alibaba.fastjson/PrimitiveArraySerializer.java)
 [final](https://github.com/mantasurbonas/amp_showcase/blob/main/com.alibaba.fastjson/PrimitiveArraySerializer.java)

Note the modernized version makes it obvious a possible incompleteness of the class responsibility: missing handling of either array of Strings or array of BigDecimals or array of BigIntegers.
