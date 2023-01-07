import Header from "../components/Header";

export default function InternalServerError500() {
    return (
        <>
            <Header />
            <h2>500</h2>
            <p>Лелеее!!! <br /> Нещо стана със сървъра</p>
            <p>Спокойно. Отидете си починете и се върнете след няколко минути.</p>
        </>
    )
}