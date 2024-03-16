<template>
  <div>
    <input type="text" v-model="phoneNumber" placeholder="請輸入手機號碼" />
    <button @click="login">登入</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phoneNumber: ''
    };
  },
  methods: {
    async login() {
      try {
        // 使用 fetch 或其他 HTTP 客戶端庫進行 RESTful API 請求
        const response = await fetch('/api/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            phoneNumber: this.phoneNumber
          })
        });

        // 檢查響應狀態
        if (response.ok) {
          // 登入成功，可以在此處執行相應的操作，例如導航到下一個頁面
          console.log('登入成功');
        } else {
          // 登入失敗，處理錯誤訊息
          console.error('登入失敗');
        }
      } catch (error) {
        // 處理請求錯誤
        console.error('發生錯誤：', error);
      }
    }
  }
};
</script>
