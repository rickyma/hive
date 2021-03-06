/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.ql.exec.spark.Statistic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SparkStatisticGroup {
  private final String groupName;
  private final Map<String, SparkStatistic> statistics = new LinkedHashMap<>();

  SparkStatisticGroup(String groupName, List<SparkStatistic> statisticList) {
    this.groupName = groupName;
    for (SparkStatistic sparkStatistic : statisticList) {
      this.statistics.put(sparkStatistic.getName(), sparkStatistic);
    }
  }

  public String getGroupName() {
    return groupName;
  }

  public Iterator<SparkStatistic> getStatistics() {
    return this.statistics.values().iterator();
  }

  /**
   * Get a {@link SparkStatistic} by its given name
   */
  public SparkStatistic getSparkStatistic(String name) {
    return this.statistics.get(name);
  }

  public boolean containsSparkStatistic(String name) {
    return this.statistics.containsKey(name);
  }
}
