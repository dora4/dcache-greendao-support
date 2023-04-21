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
    def latest_version = '1.0'
    implementation 'com.github.dora4:dcache-greendao-support:$latest_version'
}
```

#### 捐赠虚拟货币支持开源项目

| 币种           | 钱包地址                                   | 备注                                                         |
| -------------- | ------------------------------------------ | ------------------------------------------------------------ |
| USDT(TRC-20链) | TYVXzqctSSPSTeVPYg7i7qbEtSxwrAJQ5y         | 先发送github用户名至邮箱dora924666990@gmail.com再发送加密货币（推荐，转账快且手续费低） |
| ETH(ERC-20链)  | 0x5dA12D7DB7B5D6C8D2Af78723F6dCE4A3C89caB9 | 先发送github用户名至邮箱dora924666990@gmail.com再发送加密货币，以太坊L1本链的chainId=1，如为以太坊兼容链，请在邮箱中说明，比如bsc的chainId=56，polygon的chainId=137 |
