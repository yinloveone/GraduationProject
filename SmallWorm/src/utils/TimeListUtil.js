export default class TimeListUtil{

   static addDate(date, days) {
        let d = new Date(date);
        d.setDate(d.getDate() + days);
        let m = d.getMonth() + 1;
        return  m + '月' + d.getDate()+ '日';
    }
   static getWeeks(date){
        let arrDate = [];
        for (let i = 0; i < 7; i++) {
            arrDate.push(this.addDate(new Date(date), i));

        }
        return arrDate;
    }


}