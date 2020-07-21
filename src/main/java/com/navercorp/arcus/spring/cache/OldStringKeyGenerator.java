/*
 * arcus-spring - Arcus as a caching provider for the Spring Cache Abstraction
 * Copyright 2020 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.arcus.spring.cache;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class OldStringKeyGenerator implements KeyGenerator {
  private static final String DEFAULT_SEPARTOR = ",";

  @Override
  public Object generate(Object target, Method method, Object... params) {
    StringBuilder keyBuilder = new StringBuilder();
    for (int i = 0, n = params.length; i < n; i++) {
      if (i > 0) {
        keyBuilder.append(DEFAULT_SEPARTOR);
      }
      if (params[i] != null) {
        keyBuilder.append(params[i]);
      }
    }
    return new ArcusStringKey(keyBuilder.toString());
  }
}
