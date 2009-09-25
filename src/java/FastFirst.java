/*
  Copyright 2009 RapLeaf

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
import java.util.Iterator;

import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Buffer;
import cascading.operation.BufferCall;
import cascading.tuple.Fields;
import cascading.tuple.TupleEntry;

public class FastFirst extends BaseOperation implements Buffer {
  public FastFirst() {
    super(Fields.ARGS);
  }

  public void operate(FlowProcess process, BufferCall call) {
    Iterator<TupleEntry> args = call.getArgumentsIterator();
    if(args.hasNext()) {
      TupleEntry tupleEntry = args.next();
      call.getOutputCollector().add(tupleEntry);
    }
  }  
}