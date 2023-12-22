<template>
	<div class="container">
		<TopBar></TopBar>
		<!-- 将此页面分成上，中，下三个部分 -->
		<div class="main">
			<div class="up">
				<!-- <div class="decoration">
					<div class="bgimage" v-for="item in bookList" :key="item.id">
						<Book :text="item.text" :imgone="item.img"></Book>
					</div>
				</div>
 -->
				<div class="my">
					<div class="ke">
						<div class="img">
							<!-- 用户头像 -->
							<img :src="userMessage.avatarUrl" alt="" />
						</div>
						<div class="name">
							<!-- 用户姓名及后面的各种标志部分 -->
							<div class="name_icon">
								<div class="username">{{ userMessage.nickname }}</div>
								<!-- 昵称边上的图标部分可以加在下面 -->
							</div>
							<!-- 用户个性签名部分-->
							<div class="personwrite">展示你的个性签名吧</div>
						</div>
						<!-- 左部编辑，设置按钮 -->
						<!-- <div class="button">
						</div> -->
						<div v-if="localUserId === userMessage.id" class="button">
							<button class="edit" @click="TurnToEdit()">编辑资料</button>
							<!-- <button class="set">设置</button> -->
						</div>
					</div>
				</div>
			</div>
			<div class="middle">
				<!-- 中部导航部分使用封装的子组件NewPersonBlogContent-->
				<NewPersonBlogContent
					:userId="userMessage.id"
					:avatarUrl="userMessage.avatarUrl"
					:username="userMessage.nickname"
				/>
			</div>
			<!--            <div class="down">-->
			<!--                &lt;!&ndash; 底部信息 &ndash;&gt;-->
			<!--            </div>-->
		</div>
	</div>
</template>

<script>
// 导入顶部导航条
import TopBar from "../components/content/topbar/TopBar.vue";
import qs from "qs";
import Book from "@/components/P_user/CssAnimation/PageTurnBook.vue";
// 引入中部大导航
import NewPersonBlogContent from "@/components/P_user/NewPersonBlogContent/NewPersonBlogContent.vue";
export default {
	components: {
		TopBar,
		NewPersonBlogContent,
		Book,
	},
	data() {
		return {
			userMessage: {},
			config: {
				headers: {
					token: localStorage.getItem("token"),
				},
			},
			localUserId:
				localStorage.getItem("userMessage") == null
					? 0
					: JSON.parse(localStorage.getItem("userMessage")).id,
			// 书的信息
			bookList: [
				{
					text: "这是装饰1",
					img: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202003%2F05%2F20200305204026_zvphr.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1705634745&t=040aceeb0395bfa0870ad9293898a692",
					// img: "https://tse4-mm.cn.bing.net/th/id/OIP-C.LWGT942vEnu7BJUpYbAyogHaFP?w=213&h=180&c=7&r=0&o=5&dpr=1.12&pid=1.7",
					id: 1,
				},
				{
					text: "这是装饰2",
					// img:'',
					id: 2,
				},
				{
					text: "这是装饰3",
					img: "https://img2.baidu.com/it/u=3496011114,654559464&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=800",
					id: 3,
				},
				// {
				// 	text: "就知道你忍不住看",
				// 	img: "https://img1.baidu.com/it/u=907523513,3087938631&fm=253&fmt=auto&app=138&f=JPEG?w=231&h=500",
				// 	id: 4,
				// },
				// {
				// 	text: "三万里河东入海，五千仞岳上摩天。",
				// 	img: "https://img0.baidu.com/it/u=3872372553,3353954591&fm=253&fmt=auto&app=138&f=JPEG?w=485&h=500",
				// 	id: 5,
				// },
				// {
				// 	text: "昆仑山上玉楼前，五色祥光混紫烟。",
				// 	img: "https://img1.baidu.com/it/u=1637045404,3074886103&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889",
				// 	id: 6,
				// },
				// {
				// 	text: "飞流直下三千尺，疑似银河落九天",
				// 	img: "https://lmg.jj20.com/up/allimg/tp01/1ZZH3243052B-0-lp.jpg",
				// 	id: 7,
				// },
			],
		};
	},
	created() {
		// console.log(this.$route.params.userId);
		// console.log(localStorage.getItem("token"));
		this.GetData();
	},
	methods: {
		async GetData() {
			this.$axios
				.get("/user", {
					params: { id: this.$route.params.userId },
					headers: { token: localStorage.getItem("token") },
				})
				.then((res) => {
					// console.log(res.data);
					this.userMessage = res.data.data;
					// console.log(this.userMessage.id);
				});

			// 获取用户个人信息
			//  console.log(JSON.parse(localStorage.getItem('userMessage')),"所有个人信息")
		},
		// 跳转至编辑个人信息页面
		TurnToEdit() {
			this.$router.push("/PersonalInfoEdit");
		},
	},
};
</script>

<style scoped>
.container {
	width: 100%;
	min-height: 100vh;
	background: rgb(247, 248, 249);
}
.main {
	width: 100%;
	padding-top: 2vh;
}
.up {
	width: 1300px;
	/* height: 200px; */
	margin: 0 auto;
	position: relative;
	/* background: url('../assets/img/newPersonBlog/tip.webp') no-repeat; */
	background: linear-gradient(
		135deg,
		rgb(235, 195, 245),
		white,
		rgb(230, 82, 62)
	);
	border-radius: 5px;
}
.up .decoration {
	width: 100%;
	top: 0;
	left: 0;
	display: flex;
	justify-content: space-around;
}
.up .bgimage {
	margin: 20px 20px 20px 0;
	border: none;
}
.my {
	width: 100%;
	height: 100px;
}
/* 包裹上部分文字头像显示部分的壳 */
.ke {
	width: 100%;
	height: 100px;
	padding-left: 20px;
	padding-bottom: 10px;
	display: flex;
	align-items: center;
}
/* 头像包裹部分 */
.img {
	width: 80px;
	height: 80px;
	overflow: hidden;
	border: 3px solid rgb(234, 234, 234);
	border-radius: 50%;
}
/* 头像本体 */
.img img {
	width: 100%;
	height: 100%;
}
/* 用户名字部分的区域 */
.name {
	width: 60%;
	height: 100%;
	margin-left: 20px;
}
/* 昵称及其余图标部分 */
.name .name_icon {
	width: 100%;
	height: 35px;
	line-height: 40px;
	margin-top: 5px;
}
/* 用户昵称显示 */
.name .name_icon .username {
	font-size: 22px;
	font-weight: 800;
	color: white;
}
/* 个人签名部分 */
.name .personwrite {
	width: 100%;
	/* height: 40px; */
	margin-top: 10px;
	color: white;
}
.ke .button {
	width: 10%;
	margin-left: 230px;
}
.button button {
	height: 30px;
	border: none;
	border-radius: 5px;
	color: rgb(255, 255, 255);
	background: rgb(68, 201, 211);
	transition: all 0.5s;
}
.button button:hover {
	background: rgb(251, 46, 0);
	box-shadow: 0 2px 5px rgb(93, 93, 93);
}
/* 按钮被点击时 */
.button button:active {
	border: 4px solid white;
	background: rgb(14, 199, 255);
}
.button .edit {
	width: 125px;
}

.button .set {
	margin-left: 20px;
	width: 100px;
}
/* 中部大导航部分 */
.middle {
	width: 1300px;
	margin: 20px auto 0;
}
</style>
