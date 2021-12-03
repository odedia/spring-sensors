
load('.tanzu/tanzu_tilt_extensions.py', 'tanzu_k8s_yaml')
allow_k8s_contexts('tap')
allow_k8s_contexts('tap-cluster')
SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='harbor.apps.cf.tanzutime.com/apps/spring-sensors')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')

custom_build('harbor.apps.cf.tanzutime.com/apps/spring-sensors',
    "tanzu apps workload apply -f config/workload.yaml --live-update \
      --local-path " + LOCAL_PATH + " --source-image " + SOURCE_IMAGE + " --yes && \
    .tanzu/wait.sh spring-sensors",
  ['pom.xml', './target/classes'],
  live_update = [
    sync('./target/classes', '/workspace/BOOT-INF/classes')
  ],
  skips_local_docker=True
)

tanzu_k8s_yaml('spring-sensors', 'harbor.apps.cf.tanzutime.com/apps/spring-sensors', './config/workload.yaml')
