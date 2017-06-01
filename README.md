# tpscalculator
Requirements : Maven and Java should be installed on your computer.

First you should run sh/bat file inside the server package. It will create hazelcast cluster with 2 nodes.

Then start the hazelcast client through sh/bat file. It will print TPS.

Client's thread size is changeable. We can change that to reach highest throughput. It is changed from application.properties file inside in the client\src\main\resources.