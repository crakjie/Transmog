object Tester {
 val str1 = """[StartPipe,
AsPipe(pipelineStart,PropertyFilterPipe(class_,EQUAL,com.misterbell.shed.models.frames.Event)),
AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[status],vertex),PropertyFilterPipe(name,NOT_EQUAL,DELETED)])),
AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[tracking],vertex), BackFilterPipe([VertexQueryPipe(out,[status],vertex), PropertyFilterPipe(name,NOT_EQUAL,DELETED)]), OrFilterPipe([HasNextPipe([PropertyFilterPipe(uid,EQUAL,tracking-39aa-4104-aecc-activated007)])])])),

AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[fingerprint],vertex),
 BackFilterPipe([VertexQueryPipe(out,[status],vertex),
 PropertyFilterPipe(name,NOT_EQUAL,DELETED)]),
 OrFilterPipe([HasNextPipe([PropertyFilterPipe(hash,EQUAL,53a7c63fcb2101f92d8a1d870095daa5)])])])),
 AsPipe(has,BackFilterPipe([OrFilterPipe([HasNextPipe([PropertyFilterPipe(created_at,GREATER_THAN,1411653801140)])])])),
 BackFilterPipe([VertexQueryPipe(out,[validity],vertex),
 BackFilterPipe([VertexQueryPipe(out,[status],vertex),
 PropertyFilterPipe(name,NOT_EQUAL,DELETED)]),
 OrFilterPipe([HasNextPipe([PropertyFilterPipe(reason,NOT_EQUAL,DUPLICATE)])])])]"""
                                                  //> str1  : String = [StartPipe,
                                                  //| AsPipe(pipelineStart,PropertyFilterPipe(class_,EQUAL,com.misterbell.shed.mo
                                                  //| dels.frames.Event)),
                                                  //| AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[status],vertex),PropertyFil
                                                  //| terPipe(name,NOT_EQUAL,DELETED)])),
                                                  //| AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[tracking],vertex), BackFilt
                                                  //| erPipe([VertexQueryPipe(out,[status],vertex), PropertyFilterPipe(name,NOT_E
                                                  //| QUAL,DELETED)]), OrFilterPipe([HasNextPipe([PropertyFilterPipe(uid,EQUAL,tr
                                                  //| acking-39aa-4104-aecc-activated007)])])])),
                                                  //| 
                                                  //| AsPipe(has,BackFilterPipe([VertexQueryPipe(out,[fingerprint],vertex),
                                                  //|  BackFilterPipe([VertexQueryPipe(out,[status],vertex),
                                                  //|  PropertyFilterPipe(name,NOT_EQUAL,DELETED)]),
                                                  //|  OrFilterPipe([HasNextPipe([PropertyFilterPipe(hash,EQUAL,53a7c63fcb2101f92
                                                  //| d8a1d870095daa5)])])])),
                                                  //|  AsPipe(has,BackFilterPipe([OrFilterPipe([HasNextPipe([PropertyFilterPipe(c
                                                  //| reated_at,GREATER_THAN,1411653801140)])])])),
                                                  //|  Bac
                                                  //| Output exceeds cutoff limit.




Parser.parse(str1)                                //> Parsed [14.82] parsed: g.V.as('pipelineStart').has('class_',T.eq,'com.miste
                                                  //| rbell.shed.models.frames.Event').as('has').out('status').has('name',T.neq,'
                                                  //| DELETED').back(2).as('has').out('tracking').out('status').has('name',T.neq,
                                                  //| 'DELETED').back(2).or(_.has('uid',T.eq,'tracking-39aa-4104-aecc-activated00
                                                  //| 7')).back(3).as('has').out('fingerprint').out('status').has('name',T.neq,'D
                                                  //| ELETED').back(2).or(_.has('hash',T.eq,'53a7c63fcb2101f92d8a1d870095daa5')).
                                                  //| back(3).as('has').or(_.has('created_at',T.gt,'1411653801140')).back(1).out(
                                                  //| 'validity').out('status').has('name',T.neq,'DELETED').back(2).or(_.has('rea
                                                  //| son',T.neq,'DUPLICATE')).back(3)
                                                  //| res0: Parser.ParseResult[String] = [14.82] parsed: g.V.as('pipelineStart').
                                                  //| has('class_',T.eq,'com.misterbell.shed.models.frames.Event').as('has').out(
                                                  //| 'status').has('name',T.neq,'DELETED').back(2).as('has').out('tracking').out
                                                  //| ('status').has('name',T.neq,'DELETED').back(2).or(_.has('uid',T.eq
                                                  //| Output exceeds cutoff limit.
}