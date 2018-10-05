const cacheVersion = 1.1
const currentCache = {
    offline: 'offline-cache' + cacheVersion
}
const offlineUrl = '/cache'

self.addEventListener('install', function (e) {
    e.waitUntil(
        caches.open(currentCache.offline).then(function (cache) {
            return cache.addAll([
                '/',
                '/js/jquery.js',
                '/js/lodash.js',
                '/js/angular.min.js',
                '/js/angular-animate.min.js',
                '/js/angular-aria.min.js',
                '/js/angular-messages.min.js',
                '/js/angular-material.min.js',
            ])
        })
    )
})

self.addEventListener('fetch', function (event) {
    if (event.request.mode === 'navigate' || (event.request.method === 'GET' && event.request.headers.get('accept').includes('text/html'))) {
        event.respondWith(
            fetch(event.request.url).catch(error => {
                // Return the offline page
                return caches.match(offlineUrl)
            })
        )
    }
    else {
        // Respond with everything else if we can
        event.respondWith(caches.match(event.request)
            .then(function (response) {
                return response || fetch(event.request)
            })
        )
    }
})