/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial agreement.
 */

package io.crate.operation.scalar;

import io.crate.analyze.symbol.Literal;
import io.crate.types.LongType;
import io.crate.types.SetType;
import org.junit.Test;

import java.util.HashSet;

public class CollectionCountFunctionTest extends AbstractScalarFunctionsTest {

    @Test
    public void testEvaluate() throws Exception {
        assertEvaluate("collection_count(long_set)", 2L,
            Literal.of(new HashSet<Long>() {{ add(3L); add(7L);}}, new SetType(LongType.INSTANCE)));
    }

}
