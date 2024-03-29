dcache-greendao-support
![Release](https://jitpack.io/v/dora4/dcache-greendao-support.svg)
--------------------------------

#### gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
dependencies {
    // 扩展包需要在有主框架的情况下使用
    implementation 'com.github.dora4:dcache-android:2.2.11'
    implementation 'com.github.dora4:dcache-greendao-support:1.2'
}
```
