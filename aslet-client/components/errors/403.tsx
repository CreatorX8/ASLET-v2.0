import { useRouter } from "next/router";

export default function Forbidden403() {

    const router = useRouter();

    return (
        <>
            <button onClick={() => router.back()}>X</button>
            <h2>403</h2>
            <p> Тцтцтц <br /> Изглежда нямате нужните права върху тези данни</p>
        </>
    )
}