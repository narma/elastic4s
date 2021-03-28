package com.sksamuel.elastic4s.requests.count

import com.sksamuel.elastic4s.json.XContentFactory
import com.sksamuel.elastic4s.json.builder.ContentBuilder
import com.sksamuel.elastic4s.requests.searches.queries.QueryBuilderFn

object CountBodyBuilderFn {
  def apply(request: CountRequest): ContentBuilder = {
    val builder = XContentFactory.jsonBuilder()
    request.query.map(QueryBuilderFn.apply).foreach(builder.rawField("query", _))
    builder
  }
}
