# bda2021-lab2-summer

## How to build

```shell
sbt test:compile
```

## How to run Consumer nad Producer

**Note**: before running the code below update `application.conf` with the appropriate parameters.

```shell
sbt "runMain io.datamass.EventConsumer"
```

```shell
sbt "runMain io.datamass.EventProducer"
```


