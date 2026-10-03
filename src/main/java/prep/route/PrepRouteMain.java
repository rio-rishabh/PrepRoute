package prep.route;

/**
 * PrepRoute CLI entrypoint.
 * Phase 1 stub — Gradle wiring only. FakeJev + FolderRouter come next.
 */
public final class PrepRouteMain {

    public static void main(String[] args) {
        String problem = args.length > 0
                ? String.join(" ", args)
                : "(no problem text yet — pass args or implement stdin)";

        System.out.println("PrepRoute (Gradle) is up.");
        System.out.println("problemText: " + problem);
        System.out.println("Next: FakeJevBackend + FolderRouter + OpenAPI server.");
    }

    private PrepRouteMain() {
    }
}
