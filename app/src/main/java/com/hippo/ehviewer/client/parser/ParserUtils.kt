/*
 * Copyright 2015 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hippo.ehviewer.client.parser

import com.hippo.util.toLocalDateTime
import com.hippo.yorozuya.NumberUtils
import com.hippo.yorozuya.StringUtils
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.char

object ParserUtils {
    // yyyy-MM-dd HH:mm
    private val formatter = LocalDateTime.Format {
        year()
        char('-')
        monthNumber()
        char('-')
        dayOfMonth()
        char(' ')
        hour()
        char(':')
        minute()
    }

    fun formatDate(time: Long): String = formatter.format(time.toLocalDateTime())

    fun trim(str: String?): String = str?.let { StringUtils.unescapeXml(it).trim() } ?: ""

    fun parseInt(str: String?, defValue: Int): Int = NumberUtils.parseIntSafely(trim(str).replace(",", ""), defValue)

    fun parseLong(str: String?, defValue: Long): Long = NumberUtils.parseLongSafely(trim(str).replace(",", ""), defValue)
}
